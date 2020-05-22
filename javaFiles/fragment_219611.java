m_context.InitFromXmlFile(path,m_scriptNode);                               
m_context.FindExistingNode(XN_NODE_TYPE_IMAGE, m_imageGenerator);                       
m_context.FindExistingNode(XN_NODE_TYPE_DEPTH, m_depthGenerator);                       
if (m_depthGenerator.IsCapabilitySupported(XN_CAPABILITY_ALTERNATIVE_VIEW_POINT)) {
    m_depthGenerator.GetAlternativeViewPointCap().SetViewPoint(m_imageGenerator);
}