for (int i = 0; i < ((List<BaseDTOInf>) getProjectList(searchBean)).size();i++) {

                BaseDTO list = (BaseDTO) getProjectList(searchBean).get(i);
                list.getDataMap().get("A");
                list.getDataMap().get("B");
                list.getDataMap().get("C");
                list.getDataMap().get("D");
                list.getDataMap().get("E");
                list.getDataMap().get("F");

                sb.append(list.getDataMap().get("A"));
                sb.append(',');
                sb.append(list.getDataMap().get("B"));
                sb.append(',');
                sb.append(list.getDataMap().get("C"));
                sb.append(',');
                sb.append(list.getDataMap().get("D"));
                sb.append(',');
                sb.append(list.getDataMap().get("E"));
                sb.append(',');
                sb.append('\n');

            }