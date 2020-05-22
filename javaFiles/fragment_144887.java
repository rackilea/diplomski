package com.somedomainname.someapplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

class NoteReader {
    private final FileInputStream fileInputStream;

    NoteReader(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    @SuppressWarnings("unchecked")
    List<Note> load() throws IOException {
        ObjectInputStream objectInputStream = null;
        List<Note> output = new ArrayList<>();

        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
            while (fileInputStream.available() != 0) {
                Note n = (Note) objectInputStream.readObject();
                output.add(n);
            }

        } catch (ClassNotFoundException | IOException e) {
            fileInputStream.close();
            assert objectInputStream != null;
            objectInputStream.close();

            e.printStackTrace();
        }
        return output;
    }

}