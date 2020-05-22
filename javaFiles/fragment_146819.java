runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    imV.setImageResource(stageArray.getResourceId(step, -1));
                }
            });