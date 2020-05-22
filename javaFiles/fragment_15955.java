if(outputCounter == outputBufferSize)
            {
                Utils.logcat(Const.LOGD, encTag, "Sending output buffer");
                try
                {
                    Vars.mediaSocket.getOutputStream().write(outputbuffer);
                    Vars.mediaSocket.getOutputStream().flush();
                }
                catch (IOException i)
                {
                    Utils.logcat(Const.LOGE, encTag, "Cannot send amr out the media socket");
                    Utils.dumpException(tag, i);
                }
                outputCounter = 0;
            }
            System.arraycopy(amrbuffer, 0, outputbuffer, outputCounter, encodeLength);
            outputCounter = outputCounter + encodeLength;
            Utils.logcat(Const.LOGD, encTag, "Output buffer fill: " + outputCounter);