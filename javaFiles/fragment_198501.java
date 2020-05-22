// due to order problem, transfer of elements from map to combo box have sence 
// for ordered maps, like LinkedHashMap or TreeMap
Map<String, String> strMap = new LinkedHashMap<>();
// fill map...
JComboBox<String> combo = new JComboBox<>();
// some code...
// now update the combo box content
combo.setModel(new DefaultComboBoxModel<>(strMap.values().toArray(new String[0])));