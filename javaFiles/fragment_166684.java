AdditionalHolder new_holder = (AdditionalHolder) holder;
            try {
                new_holder.templateContainer.removeViewInLayout(adView);
            } catch (Exception e) {
                e.printStackTrace();
            }
            nativeAd = manager.nextNativeAd();
            try {
                adView = NativeAdView.render(context, nativeAd, NativeAdView.Type.HEIGHT_300);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            new_holder.templateContainer.addView(adView);
            new_holder.blank_holder.setVisibility(View.GONE);