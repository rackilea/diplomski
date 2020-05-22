String id = reader.nextName();
                        if(id.equals("birthday")) {
                            Log.d("id", id);
                            reader.nextString(); // or reader.skipValue()
                        } else {
                            reader.skipValue();
                        }