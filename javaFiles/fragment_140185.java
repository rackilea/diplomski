String path = m_wcontext.getProject().getBaseDirectory() +
            File.separator + m_wcontext.getServiceName() + ".properties";

try {
    writeXML(path);
} catch (IOException e) {
    e.printStackTrace();
}