PreDefinedAttributes preDefinedAttributes = new PreDefinedAttributes(this);


        StringBuffer sb = new StringBuffer();
        sb.append("&_vpw=" + preDefinedAttributes.getWidth());
        sb.append("&_vph=" + preDefinedAttributes.getHeight());
        sb.append("&sdk_version=" + preDefinedAttributes.getSdk_version());
        sb.append("&_src=android-sdk"
                + "&_os=" + preDefinedAttributes.getMobile_os());
        sb.append("&os_version=" + preDefinedAttributes.getMobile_version());
        sb.append("&manufacturer=" + preDefinedAttributes.getMobile_manufacturer());

        Log.e("Builder Params " , sb.toString());