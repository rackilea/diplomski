while (onChangesForClient) {                 
                    Message msg = Message.obtain();
                    msg.what=1;
                    msg.obj=newData;
                    //TODO this is the comment for UI 
                    mhandleRef.sendMessage(msg);
                }
            }