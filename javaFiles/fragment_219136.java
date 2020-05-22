public void deleteMyFile(List<File> m_files){

  for(int i = 0; i < m_files.size(); i++) {
  File m_file = m_files.get(i);
  if(m_file.exists()) {
     FileUtils.deleteQuietly(m_file);
     if(m_file.isFile()) {
       m_log.error("Deleting file " + m_file.getName() +" fails");
       throw new ServiceUnavailableException("Not successfully delete the file " + m_file.getName());
     } else {
       m_log.info("Successfully delete the file " + m_file.getName());
     }
   }
  }
 }