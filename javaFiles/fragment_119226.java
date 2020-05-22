package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KeyValue {

    private int key;
    private Integer value;

    public KeyValue(int i, Integer j) {
        key  = i;
        value = j;
    }

    public static void main(String[] args) {

        List<KeyValue> arr = new ArrayList<KeyValue>();
        arr.add(new KeyValue(1, 100));
        arr.add(new KeyValue(2, 50));
        arr.add(new KeyValue(3, 10));
        Collections.sort(arr, new Comparator<KeyValue>(){

            @Override
            public int compare(KeyValue arg0, KeyValue arg1) {
                return Integer.compare(arg0.getValue(), arg1.getValue());
            }

        });
        for (KeyValue kv : arr){
            System.out.println(kv);
        }
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return "("+key+","+value.toString()+")";                
    }

}