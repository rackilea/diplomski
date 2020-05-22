public class OCRResultVo {

/**
 * errno : 0
 * msg : success
 * data : {"direction":0,"words_result_num":19,"words_result":[{"words":"车辆管理产品资料库","probability":{"variance":0.006179,"average":0.95664,"min":0.746422}},{"words":"盛简体中文","probability":{"variance":0.052477,"average":0.84753,"min":0.407953}},{"words":"户姓名段红车辆:BW53 5 i ( wbasp2101cDR76734}内莎利号,BMEW43999","probability":{"variance":0.030252,"average":0.856571,"min":0.503605}},{"words":"保险公司","probability":{"variance":0.045034,"average":0.847951,"min":0.48522}}]}
 */

private int errno;
private String msg;
private DataBean data;

public int getErrno() {
    return errno;
}

public void setErrno(int errno) {
    this.errno = errno;
}

public String getMsg() {
    return msg;
}

public void setMsg(String msg) {
    this.msg = msg;
}

public DataBean getData() {
    return data;
}

public void setData(DataBean data) {
    this.data = data;
}

public static class DataBean {
    /**
     * direction : 0
     * words_result_num : 19
     * words_result : [{"words":"车辆管理产品资料库","probability":{"variance":0.006179,"average":0.95664,"min":0.746422}},{"words":"盛简体中文","probability":{"variance":0.052477,"average":0.84753,"min":0.407953}},{"words":"户姓名段红车辆:BW53 5 i ( wbasp2101cDR76734}内莎利号,BMEW43999","probability":{"variance":0.030252,"average":0.856571,"min":0.503605}},{"words":"保险公司","probability":{"variance":0.045034,"average":0.847951,"min":0.48522}}]
     */

    private int direction;
    private int words_result_num;
    private List<WordsResultBean> words_result;

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(int words_result_num) {
        this.words_result_num = words_result_num;
    }

    public List<WordsResultBean> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<WordsResultBean> words_result) {
        this.words_result = words_result;
    }

    public static class WordsResultBean {
        /**
         * words : 车辆管理产品资料库
         * probability : {"variance":0.006179,"average":0.95664,"min":0.746422}
         */

        private String words;
        private ProbabilityBean probability;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }

        public ProbabilityBean getProbability() {
            return probability;
        }

        public void setProbability(ProbabilityBean probability) {
            this.probability = probability;
        }

        public static class ProbabilityBean {
            /**
             * variance : 0.006179
             * average : 0.95664
             * min : 0.746422
             */

            private double variance;
            private double average;
            private double min;

            public double getVariance() {
                return variance;
            }

            public void setVariance(double variance) {
                this.variance = variance;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public double getMin() {
                return min;
            }

            public void setMin(double min) {
                this.min = min;
            }
        }
    }
}
}