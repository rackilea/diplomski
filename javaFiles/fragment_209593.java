@override
public void onResult(Hypothesis hypothesis) {
Log.d(TAG, "onResult: " + + recognizer.getDecoder().getRawdata().length);

        if (hypothesis != null) {
            String text = hypothesis.getHypstr();
        }
      Decoder decoder= recognizer.getDecoder();
        short[] data = decoder.getRawdata();
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(Utils.getPublicStorageDir("recoding",".raw")));
            for (int i = 0; i < data.length; i++) {
                dos.writeShort(data[i]);
            }
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }