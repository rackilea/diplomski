Channel myChannel = channelListResponse.getItems().get(0);
        String channelId = myChannel.getId();
        System.out.println("channel id===" + channelId);
        URL url = new URL(imageurl248X1152);
        URLConnection conn = url.openConnection();
        InputStreamContent mediaContent = new InputStreamContent(
                "image/jpeg", conn.getInputStream());
        ChannelBannerResource chBannerResource = new ChannelBannerResource();
        YouTube.ChannelBanners.Insert chbannerresponse = youtube
                .channelBanners().insert(chBannerResource, mediaContent);
        ChannelBannerResource res = chbannerresponse.execute();
        System.out.println("res====" + res.getUrl());
        ChannelBrandingSettings channelBrandingSettings = new ChannelBrandingSettings();
        ChannelSettings channelSettings = new ChannelSettings();
        channelSettings.setDescription(des);
        channelSettings.setKeywords(keyword);
        channelSettings.setProfileColor(profilecolor);
        ImageSettings imageSettings = new ImageSettings();
        imageSettings.setBannerExternalUrl(res.getUrl());
        channelBrandingSettings.setChannel(channelSettings).setImage(
                imageSettings);
        Channel channel = new Channel();
        channel.setId(channelId);
        channel.setBrandingSettings(channelBrandingSettings);
        System.out.println("channel===" + channel);
        Channel updateChannelResponse = youtube.channels()
                .update("brandingSettings", channel).execute();