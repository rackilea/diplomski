package ru.str.proglot.visitor.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {


    @SuppressWarnings("unchecked")
    public static <T> T getValue(Context context, String key, T defaultValue) {
        SharedPreferences sPref = PreferenceManager.getDefaultSharedPreferences(context);
        T resultValue = null;

        if (defaultValue instanceof Boolean)
            resultValue = (T) Boolean.valueOf(sPref.getBoolean(key, (Boolean) defaultValue));
        else if (defaultValue instanceof Float)
            resultValue = (T) Float.valueOf(sPref.getFloat(key, (Float) defaultValue));
        else if (defaultValue instanceof Integer)
            resultValue = (T) Integer.valueOf(sPref.getInt(key, (Integer) defaultValue));
        else if (defaultValue instanceof Long)
            resultValue = (T) Long.valueOf(sPref.getLong(key, (Long) defaultValue));
        else if (defaultValue instanceof String)
            resultValue = (T) sPref.getString(key, (String) defaultValue);

        return resultValue;
    }

    public static <T> void setValue(Context context, String key, T value) {
        SharedPreferences sPref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sPref.edit();

        if (value instanceof Boolean)
            editor.putBoolean(key, (Boolean) value);
        else if (value instanceof Float)
            editor.putFloat(key, (Float) value);
        else if (value instanceof Integer)
            editor.putInt(key, (Integer) value);
        else if (value instanceof Long)
            editor.putLong(key, (Long) value);
        else if (value instanceof String)
            editor.putString(key, (String) value);

        editor.apply();
    }

    public static void remove(Context context, String key) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().remove(key).apply();
    }

    public static void clear(Context context ) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().clear().apply();
    }



}