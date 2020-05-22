for(int j=0; j < mParsedDataSetList.size(); j++)
        {
            ContactVO mXmldata = mParsedDataSetList.get(j);
            boolean exists = false;

            for(int i=0; i< mContacts.size(); i++)
            {
                ContactVO mShareddata = mContacts.get(i);

                if(mShareddata.comprareTo(mXmldata) == 0)
                {
                   exists = true;
                   break; 
                }
            }
            if(!exists)
            {
                mContacts.add(mXmldata);
            }
        }