switch(view.getId()) {
        case R.id.getGreetingButton:
            new RestTask().execute(Pair.create(context,1));
            break;

    }