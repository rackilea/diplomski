<div data-sly-test="${(wcmmode.edit || wcmInit.isTouchAuthoring) && (!properties.text)}">
<div>Please edit this component.</div>
<sub>This text will only appear in Authoring Mode</sub>
</div>
<div data-sly-test="${properties.text}" data-sly-unwrap>
<p data-sly-use.text="text.js" data-sly-unwrap="${text.context == text.CONST.CONTEXT_HTML}" class="${text.cssClass}" data-emptytext="Rich Text">${text.text @ context=text.context}</p>
</div>