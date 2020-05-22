public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType) {      
      return new AbstractAnnotationHover(true) {
          public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
              IAnnotationModel model = ((SourceViewer) textViewer).getAnnotationModel();
              @SuppressWarnings("unchecked")
              Iterator<Annotation> parent = 
                      ((IAnnotationModelExtension2)model).getAnnotationIterator(hoverRegion.getOffset(), 
                              hoverRegion.getLength(), true, true);
              Iterator<?> iter = new JavaAnnotationIterator(parent, false); 
              Annotation annotation = null;
              Position position = null;
              while (iter.hasNext()) {
                  Annotation a = (Annotation) iter.next();
                  Position p = model.getPosition(a);
                  annotation = a;
                  position = p;
              }
              return new AnnotationInfo(annotation, position, textViewer) {
                  public ICompletionProposal[] getCompletionProposals() {
                      ICompletionProposal proposal1 = null;
                      IMarkerResolution [] resolutions = null;
                      ICompletionProposal [] com = null;
                      if (annotation instanceof MarkerAnnotation) {
                          resolutions = new ErrorResolution().getResolutions(((MarkerAnnotation) annotation).getMarker());
                          if(resolutions.length != 0){
                              proposal1 = new MarkerResolutionProposal(resolutions[0], 
                                      ((MarkerAnnotation) annotation).getMarker());
                              return new ICompletionProposal[] { proposal1 };
                          }
                      }
                      return com ;
                  }
              };
          } 
    };
}