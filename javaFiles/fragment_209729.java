if (listDirector.get(0).getStremURL() == null) {
        new ToastMsg(DetailsActivity.this).toastIconError("Sorry but there was an error retrieving the url!");
    } else {
        intent.setData(Uri.parse(listDirector.get(0).getStremURL()));
        startActivity(Intent.createChooser(intent, "Open In"));
    }