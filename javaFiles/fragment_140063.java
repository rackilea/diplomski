case R.id.share_btn :
                shareButton.performClick();
                break;
            case R.id.share_btn_fb :
                ShareLinkContent content = new ShareLinkContent.Builder()
                        .setContentTitle("Content title")
                        .setContentDescription("App descr")
                        .setContentUrl(Uri.parse("some url"))
                        .build();
                shareButton.setShareContent(content);
                break;