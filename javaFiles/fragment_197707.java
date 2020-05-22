WaterQuality waterQuality = new WaterQuality();
//Set other fields too

CaseStudy caseStudy1 = new CaseStudy();
CaseStudy caseStudy2 = new CaseStudy();
CaseStudy caseStudy3 = new CaseStudy();
CaseStudy caseStudy4 = new CaseStudy();
//Set other fileds of case study too

List<CaseStudy> caseStudyList = waterQuality.getCaseStudyList();
caseStudyList.add(caseStudy1);
caseStudyList.add(caseStudy2);
caseStudyList.add(caseStudy3);
caseStudyList.add(caseStudy4);

waterQualityService.save(waterQuality);