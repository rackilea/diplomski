DiffRowGenerator generator = DiffRowGenerator.create()
                .showInlineDiffs(true)
                .mergeOriginalRevised(true)
                .inlineDiffByWord(true)
                .newTag(f -> f?"<span style=\"background-color:#ffc6c6\">":"</span>")
                .oldTag(f -> f?"<span style=\"background-color:#c4ffc3\">":"</span>")
                .columnWidth(10000000)
                .build();

List<DiffRow> rows = generator.generateDiffRows(
                Arrays.asList(lines.get(0)),
                Arrays.asList(lines.get(1)));

System.out.println(rows.get(0).getOldLine());