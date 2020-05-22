Iterator<Parameter> iter = m_lastValues.keySet().iterator();
while (iter.hasNext()) {
    Parameter current = iter.next();
    for (int i = 0; i < m_monitorList.size(); i++) {
        if(current.equals(m_monitorList.get(i)) {
            iter.remove();
            break;
        }
    }
}