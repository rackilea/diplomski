// List, not array
List<String> m_cPackageName = new ArrayList<String>();

// ..
if ((m_appinfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
    // Only added to list sometimes, but m_cPackageName.size() is
    // always the count of elements that HAVE been added.
    m_cPackageName.add(pi.packageName);
}

// Then, if you really need an array, which will now be the proper size
// and not contain null elements because the size is computed based on the
// accepted elements in m_cPackageName which is m_cPackageName.size() ..
String[] arrayOfPackageNames = m_cPackageName.toArray(new String[0]);