filePaths.stream()
                .map(filePath -> new FilePathDTO(filePath, Imgcodecs.imread(filePath), filePaths.indexOf(filePath) != filePaths.size() - 1))
                .forEach(dto -> {
                    cvtColor(dto.getMat(), dto.getGrey(), 6);

                    if(dto.isNotLastFilepath) {
                        threshold(dto.getGrey(), dto.getGrey(), 150, 255, THRESH_TRUNC);
                    }

                    Imgcodecs.imwrite(dto.getFilepath(), dto.getGrey());
                });