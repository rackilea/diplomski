Converter<Collection<Candidature>, String> convertLastDateToString = new Converter<Collection<Candidature>, String>() {
        public String convert(MappingContext<Collection<Candidature>, String> context) {

            List<Candidature> candidatureList = (List)context.getSource();

            String dateInterviewConverted = "";

            if (candidatureList.size() > 0) {
                Date lastInterview = candidatureList.get(0).getDateInterview();
                for (int i = 0; i < candidatureList.size(); i++) {
                    if (candidatureList.get(i).getDateInterview().after(lastInterview)) {
                        lastInterview = candidatureList.get(i).getDateInterview();
                    }
                }

                // converts the Date to String
                DateFormat df = new SimpleDateFormat(DATE_FORMAT);
                dateInterviewConverted = df.format(lastInterview);
            }

            return dateInterviewConverted;
        }
    };

    // allows custom conversion for Title attribute
    // the source (Candidate) has a title attribute in int type
    // the destination (CandidateDTO) has a title attributes in String type
    Converter<Integer, String> convertTitleToString = new Converter<Integer, String>(){
        public String convert(MappingContext<Integer, String> context){
           return Title.values()[context.getSource()].toString();
        }

    };

    // define explicit mappings between source and destination properties
    // does only concernes the attributes that will need custom mapping
    PropertyMap<Candidate, CandidateDTO> candidateMapping = new PropertyMap<Candidate, CandidateDTO>()
    {
        protected void configure()
        {
            // to map these two attributes, they will use the corresponding converters
            using(convertTitleToString).map(source.getTitle()).setTitle(null);
            using(convertLastDateToString).map(source.getCandidatures()).setDateLastInterview(null);
        }
    };

    // add the mapping settings to the ModelMapper
    modelMapper.addMappings(candidateMapping);