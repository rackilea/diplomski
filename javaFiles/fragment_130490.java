List<Object> result = walk.filter(f -> f.toString().endsWith(".dat")).collect(Collectors.toList());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (int i = 0; i < result.size(); i++) {
                File file = new File(result.get(i).toString());
                for (Date date = day; !date.after(localDate); date = DateUtils.addDays(date, 1)) {
                    if (sdf.format(file.lastModified()).equals(sdf.format(date))) {
                        temp.append(file.getAbsolutePath() + ";");
                        totalDat++;
                    }
                }
            }