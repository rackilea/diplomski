<!DOCTYPE ui:UiBinder SYSTEM "http://dl.google.com/gwt/DTD/xhtml.ent">
<ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
  xmlns:g="urn:import:com.google.gwt.user.client.ui">
  <ui:style>
    .conversationPanelContainer, .conversationPanel, .messageTextAndSendPanel, .messageText {
      font-weight: bold;
    }
  </ui:style>
    <g:SplitLayoutPanel>
    <g:north size="700">
        <g:VerticalPanel>
                <g:ScrollPanel styleName="{style.conversationPanelContainer}">
                    <g:FlexTable ui:field="conversationPanel" styleName="{style.conversationPanel}"></g:FlexTable>
                </g:ScrollPanel>
                <g:HorizontalPanel styleName="{style.messageTextAndSendPanel}">
                    <g:TextBox ui:field="messageText" styleName="{style.messageText}"></g:TextBox><g:Button ui:field="sendButton">Send</g:Button>
                </g:HorizontalPanel>
        </g:VerticalPanel>
    </g:north>
    <g:south size="300">
    <g:Button>TestButton</g:Button>
    </g:south>
    </g:SplitLayoutPanel>
</ui:UiBinder>