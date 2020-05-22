int size = nameBlock.length;
        for(int i = 0 ; i < size; i++) {
            Log.d("FREINDADD", "Freind Added" + i);
            list.add(new Friend(i, names.get(i), descr.get(i), images.get(i)));
            //friendList2.add(new Friend(i, names.get(i), descr.get(i), images.get(i), friendIds.get(i)));
        }
        Log.i("Application", "Application started succesfully...");