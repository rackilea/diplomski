public IQuickAssistAssistant getQuickAssistAssistant(ISourceViewer sourceViewer) {
  IQuickAssistAssistant quickAssist = new QuickAssistAssistant();
  quickAssist.setQuickAssistProcessor(new MyQuickAssistProcessor());
  quickAssist.setInformationControlCreator(getInformationControlCreator(sourceViewer));
  return quickAssist; 
}