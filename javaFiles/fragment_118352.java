for(int i = 0; i < list.size(); i++)
            {
                String replaceTag = list.get(i).toString().replaceAll("[(),]", "");
                int valueofReplaceTag = (int)Long.parseUnsignedLong(replaceTag, 16);
                if(dcmObj.vrOf(valueofReplaceTag).equals(VR.DA))
                    {
                        dcmObj.putString(valueofReplaceTag, dcmObj.vrOf(valueofReplaceTag), "20150101");
                    }
                    else if(dcmObj.vrOf(valueofReplaceTag).equals(VR.DT))
                    {
                        dcmObj.putString(valueofReplaceTag, dcmObj.vrOf(valueofReplaceTag), "20150101");
                    }
            }