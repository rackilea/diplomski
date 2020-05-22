pic.load(path).into(ivi, new Callback()
            {
                @Override
                public void onSuccess()
                {
                    Timber.d("Image Loaded Successfully");
                }

                @Override
                public void onError()
                {
                    Timber.d("Image Load Error");
                }
            });