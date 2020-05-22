<style>

.menubar-wrapper {
  width: 100px;
  margin: 0 auto;
}
</style>


<g:DockPanel>
    <g:Dock direction='NORTH' >
        <g:SimplePanel styleName="{style.menubar-wrapper}">
            <g:MenuBar ui:field="mainMenu"/>
        </g:SimplePanel>
    </g:Dock>
</g:DockPanel>