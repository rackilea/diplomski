package com.spring.batch.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.item.ItemWriter;

public class UserItemWriter implements ItemWriter<User> {

    private static Map<String, List<String>> userMap = new HashMap<String, List<String>>();

    public void write(List<? extends User> users) throws Exception {

        for (User user : users) {
            List<String> list = userMap.get(user.getUserId());
            if (list == null) {
                list = new ArrayList<String>();
            }
            list.add(user.getUserData());
            userMap.put(user.getUserId(), list);
        }
    }

    public static Map<String, List<String>> getUserMap() {
        return userMap;
    }

}