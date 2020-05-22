package com.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import io.realm.RealmList;

/**
 * Person
 * Created by Maher Abuthraa on 6/9/17.
 */

public class Person implements Parcelable {
    @PrimaryKey
    private long id;

    private String name;
    private RealmList<Dog> mRealmList;

    public Person() {
    }

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public RealmList<Dog> getRealmList() {
        return mRealmList;
    }

    public Person setRealmList(ArrayList<Dog> dogList) {
        mRealmList = new RealmList<>();
        mRealmList.addAll(dogList);
        return this;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeTypedList(this.mRealmList);
    }

    protected Person(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.mRealmList = new RealmList<>();
        this.mRealmList.addAll(in.createTypedArrayList(Dog.CREATOR));
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}