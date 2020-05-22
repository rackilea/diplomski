class Converter {
    ConversionAlgorithm algo;
    File file; // file to convert

    Converter(File file) {
        this.file = file;
    }

    void setConversionAlgorithm(ConversionAlgorithm algo) {
        this.algo = algo;
    }

    File convert() {
        return algo.convert(file);
    }
}

interface ConversionAlgorithm {
    File convert(File toConvert);
}

class JSONConverter implements ConversionAlgorithm {

    @Override
    File convert(File toConvert) {
        // do the conversion from xml to json
    }
}

class CSVConverter implements ConversionAlgorithm {

    @Override
    File convert(File toConvert) {
        // do the conversion from xml to csv
    }
}