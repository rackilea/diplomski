public static void formatUnitSourceCode(ICompilationUnit unit, IProgressMonitor monitor) throws JavaModelException {
    CodeFormatter formatter = ToolFactory.createCodeFormatter(null);
    ISourceRange range = unit.getSourceRange();
    TextEdit formatEdit = formatter.format(CodeFormatter.K_COMPILATION_UNIT, unit.getSource(), range.getOffset(), range.getLength(), 0, null);
    if (formatEdit != null && formatEdit.hasChildren()) {
        unit.applyTextEdit(formatEdit, monitor);
    } else {
        monitor.done();
    }
}