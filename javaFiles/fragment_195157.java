public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
    /* some code */
    TemplateContext context= createContext(viewer, region);
    if (context == null)
        return new ICompletionProposal[0];

    context.setVariable("selection", selection.getText()); // name of the selection variables {line, word}_selection //$NON-NLS-1$

    Template[] templates= getTemplates(context.getContextType().getId());
    /* some code */
    return (ICompletionProposal[]) matches.toArray(new ICompletionProposal[matches.size()]);
}