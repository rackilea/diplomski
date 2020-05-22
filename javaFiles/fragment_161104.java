row[2] = createDistributionComboBoxForRing(k);
row[3] = String.format("%.2f", plume.getThicknessOfRing(k));
row[4] = String.format("%.2f", plume.getTimeForRing(k));
row[5] = String.format("%.2f", plume.getRateForRing(k));
row[6] = new JCheckBox();
((JCheckBox) row[6]).setSelected(true);