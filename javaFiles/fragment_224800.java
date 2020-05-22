package com.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class TestClass {

    public static void main(String[] args) {
        Gson gson = new Gson();

        try {

            String jsonString = " { 'Buys': { 'bHeading1': { 'bkey1': 'value1', 'bkey2': 'value2', 'bkey3': 'value3' }, 'bbHeading2': { 'bbkey1': 'value1', 'bbkey2': 'value2', 'bbkey3': 'value3' } }, "
                    + "'Sells': { 'sHeading1': { 'skey1': 'value1', 'skey2': 'value2', 'skey3': 'value3' }, 'ssHeading2': { 'sskey1': 'value1', 'sskey2': 'value2', 'sskey3': 'value3' } }, "
                    + "'TAChanges': { 'Heading1': { 'key1': 'value1', 'key2': 'value2', 'key3': 'value3' }, 'Heading2': { 'key1': 'value1', 'key2': 'value2', 'key3': 'value3' } }, 'Existing': { 'Heading1': { 'key1': 'value1', 'key2': 'value2', 'key3': 'value3' }, 'Heading2': { 'key1': 'value1', 'key2': 'value2', 'key3': 'value3' } }, 'Proposed': { 'Heading1': { 'key1': 'value1', 'key2': 'value2', 'key3': 'value3' }, 'Heading2': { 'key1': 'value1', 'key2': 'value2', 'key3': 'value3' } }, 'PIAChanges': { 'Heading1': { 'key1': 'value1', 'key2': 'value2', 'key3': 'value3' }, 'Heading2': { 'key1': 'value1', 'key2': 'value2', 'key3': 'value3' } } }";


            // convert to java class
            ProposalAggregation obj = gson.fromJson(jsonString, ProposalAggregation.class);
            System.out.println("OBJECT : " + obj);

            // convert to json
            String jsonStringFromObj = gson.toJson(obj);
            System.out.println("JSON : " + jsonStringFromObj);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}