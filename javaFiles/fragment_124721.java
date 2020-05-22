new CustomTypeDialog(context, new CustomTypeDialog.OnDialogClickListener() {
            @Override
            public void onDialogImageRunClick() {
                   txtType.setText("Run");
                   routeType.setBackgroundResource(R.drawable.track_run);
            }
      });