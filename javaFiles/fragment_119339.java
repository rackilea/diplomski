finish();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            startActivity(new Intent(getContext(), YourMainActivity.class));// then call again