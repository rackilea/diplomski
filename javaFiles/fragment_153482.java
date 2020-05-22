case OFFSET_P1_GEN:
                switch(type)
                {
                    case TwineCipher.TWINE_CIPHER_80:
                        TwineCipher m_instance = TwineCipher.getInstance(TwineCipher.TWINE_CIPHER_80);
                        apdu.setIncomingAndReceive();
                        len_data = m_instance.process(TwineCipher.OFFSET_P1_GEN, buf, (short)(ISO7816.OFFSET_CDATA), count_data);
                        apdu.setOutgoingAndSend(ISO7816.OFFSET_CDATA, len_data);
                        return;
//.....