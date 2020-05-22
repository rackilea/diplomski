int lineNum = document.getLineNumber(needHighlightPsiElement.getTextRange().getStartOffset());
final TextAttributes textattributes = new TextAttributes(null, backgroundColor, null, EffectType.LINE_UNDERSCORE, Font.PLAIN);
final Project project = needHighlightPsiElement.getProject();
final FileEditorManager editorManager = FileEditorManager.getInstance(project);
final Editor editor = editorManager.getSelectedTextEditor();    
editor.getMarkupModel().addLineHighlighter(lineNum, HighlighterLayer.CARET_ROW, textattributes);