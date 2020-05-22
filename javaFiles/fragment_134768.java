String sFilePath = this.m_sLogFolderPath + File.separator;
                if(this.m_File2Active == true)
                {
                    sFilePath += Def.DEF_FILE2;
                }
                else
                {
                    sFilePath += Def.DEF_FILE1;
                }
                File file = new File(sFilePath);
                if(file.length() > this.m_lMaxSize)
                {
                    this.m_bwWriter.flush();
                    this.m_bwWriter.close();
                    this.m_bwWriter = null;
                    sFilePath = this.m_sLogFolderPath + File.separator;
                    if (this.m_File2Active == true)
                    {
                        sFilePath += Def.DEF_FILE1;
                        this.m_File2Active = false;
                    }
                    else
                    {
                        sFilePath += Def.DEF_FILE2;
                        this.m_File2Active = true;
                    }
                    this.m_bwWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sFilePath, true), Def.DEF_ENCODING_UTF8));
                }