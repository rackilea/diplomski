List<Planejado> planejados = new ArrayList<Planejado>();
        int i = 0;
        int linha = 5;

        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\fs0234\\Desktop\\Projetos\\Realizado X Planejado\\Planej. Semanal por CC do Funcionário (20).xls");
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            HSSFSheet sheet = wb.getSheetAt(0);

            int rowMax = sheet.getLastRowNum();

            while (i <= rowMax) { // Loop até a última linha da planilha

                Row row = sheet.getRow(linha);

                if (row != null) { // Apenas linhas "não nulas"
                    Cell cell = row.getCell(8); // obter valor da celula I

                    if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) { //Verifica se a coluna I é nula
                        Cell CC = row.getCell(6); // obter valor da celula G
                        Cell nome = row.getCell(10); // obter valor da celula K

                        Planejado planejado = new Planejado();
                        planejado.setCentroCusto("CC - " + CC);
                        planejado.setNomeRecurso("Recurso - " + nome);

                        for (int j = 1, weekCol = 22; j <= 53; j++, weekCol++) { // Loop para pegar todas as semanas

                            Cell week = row.getCell(weekCol); // Obter valor da coluna da semana

                            if (week != null) {
                                planejado.getTimecard().put("Semana" + j, week.getNumericCellValue());
                            } else {
                                planejado.getTimecard().put("Semana" + j, Double.valueOf(0));
                            }
                        }
                        planejados.add(planejado);
                    }
                }
                linha++;
                i++;
            }

            for (Planejado planejado : planejados) { 
                StringBuffer timecard = new StringBuffer();

                for (int k = 1; k < 53; k++) {
                    timecard.append("Semana " + k);
                    timecard.append(": ");
                    timecard.append(planejado.getTimecard().get("Semana" + k));
                    timecard.append(", ");
                }

                System.err.println(planejado.getCentroCusto() + " | " + planejado.getNomeRecurso() + " | " + timecard.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }