switch (requestCode) {
        case VOICE_REC: {
            if (resultCode == Activity.RESULT_OK) {
                ArrayList<String> dico =  data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                resultList.setText(dico.get(0));

            }
            break;
        }
    }