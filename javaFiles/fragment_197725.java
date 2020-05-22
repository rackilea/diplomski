package com.example.android.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.lang.reflect.Field;

public class ResourceReflectionUtils {
    private static final String TAG = ResourceReflectionUtils.class.getName();
    private final static String RESOURCE_LOCATION_DRAWABLES = ".R.drawable";
    private final static String RESOURCE_LOCATION_LAYOUT = ".R.layout";
    private final static String RESOURCE_LOCATION_STRING = ".R.string";

    public static Class<?> getResourceClass(Context context, final String suffix) throws PackageManager.NameNotFoundException {
        PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            try {
                final Class<?> rClassBase = Class.forName(info.packageName + ".R");
                final Class<?>[] subClassTable = rClassBase.getDeclaredClasses();

                for (Class<?> subClass : subClassTable) {
                    if (subClass.getCanonicalName().endsWith(suffix)) {
                        return subClass;
                    }
                }
            } catch (ClassNotFoundException e) {
                Log.e(TAG, "getResourceClass() ClassNotFoundException: " + e.getMessage(), e);
            }

            Log.e(TAG, "getResourceClass() Unable to find Sublass: " + suffix);

            return null;
    }

    public static void logFields(Context context, String subclassname) {
        try {
            final Field[] fields = getResourceClass(context, subclassname).getFields();
            for (Field field : fields) {
                Log.d(TAG, "logFields() Field: '" + field.getName() + "'");
            }
        } catch (NullPointerException | PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void logSubClasses(String baseClass) {
        Log.d(TAG, "logSubClasses() Getting subclasses for '" + baseClass + "' ============= ");

        try {
            final Class<?> rClass = Class.forName(baseClass);
            final Class<?>[] subClassTable = rClass.getDeclaredClasses();

            for (final Class<?> subclass : subClassTable) {
                Log.d(TAG, "logSubClasses() Class: " + subclass.getCanonicalName());
            }

        } catch (Exception e) {
            Log.e(TAG, "logSubClasses() Error: " + e.getMessage(), e);
        }
    }

    public static int[] getDrawableIds(Context context) {
       return getIds(context, RESOURCE_LOCATION_DRAWABLES);
    }

    public static int[] getIds(Context context, String subclass) {
        int[] ids = null;
        try {
            final Field[] fields = getResourceClass(context, subclass).getFields();
            ids = new int[fields.length];
            int ii = 0;
            for (Field field : fields) {
                field.setAccessible(true);
                ids[ii] = field.getInt(null);
                Log.d(TAG, "logFields() Field: '" + field.getName() + "'");
                ii++;
            }
        } catch (NullPointerException | PackageManager.NameNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
        return ids;
    }

    protected static int reflectDrawable(Context context, String fieldName, int defaultValue, boolean reportFailure) {
        return reflectResource(context, RESOURCE_LOCATION_DRAWABLES, fieldName, defaultValue, reportFailure);
    }

    private static int reflectResource(Context context, String resourceLocation, String fieldName, int defaultValue, boolean reportFailure) {
        int error = 0;
        try {
            final Field field = getResourceClass(context, resourceLocation).getField(fieldName);
            return field.getInt(null);
        } catch (NoSuchFieldException e) {
            error = 1;
        } catch (IllegalAccessException e) {
            error = 2;
        } catch (NullPointerException e) {
            error = 3;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        if (reportFailure) {
            Log.w(TAG, "reflectResource() Resource '" + fieldName + "' not available! (" + error +")");
        }

        return defaultValue;
    }
}