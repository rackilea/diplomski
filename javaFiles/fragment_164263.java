package com.solution.sa.stack_camerasql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by asim on 10/27/2015.
 */
public class Imagehelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "clothes.db";
    private static final int SCHEMA_VERSION = 3;

    public Imagehelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("CREATE TABLE Image(_id INTEGER PRIMARY KEY AUTOINCREMENT,imageblob BLOB);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insert(byte[] bytes) {
        ContentValues cv = new ContentValues();

        cv.put("imageblob", bytes);
        Log.e("inserted", "inserted");
        getWritableDatabase().insert("Image", "imageblob", cv);

    }

    public Cursor getAll() {
        return (getReadableDatabase().rawQuery("SELECT  imageblob FROM Image", null));
    }



}