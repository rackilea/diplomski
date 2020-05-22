<!DOCTYPE ui:UiBinder SYSTEM "http://dl.google.com/gwt/DTD/xhtml.ent">
<ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
    xmlns:g="urn:import:com.google.gwt.user.client.ui">
    <ui:style>
        .important { font-weight: bold;}
        .westPanel{background-color: #EEE;}
        .northPanel{background-color: #39F;
                border-width: 1px;
                border-style: solid;
                border-color: blue;}
             .h2 {color: #cacaca;
                 text-align: center;
                 font-family: Arial, Helvetica;
                 font-weight: bold;
                 font-size: 1.3em;}
        .southPanel{background-color: #99C;}
        .centerPanel{background-color: #FFC;}
        .botaoR{width: 120px; 
            height: 40px; 
            cursor: pointer;}
    </ui:style>

    <g:DockLayoutPanel unit='EM'>

        <g:north size='2'>
            <g:FlowPanel styleName="{style.northPanel}">
                <g:Label styleName="{style.h2}" text="Gestor de Horarios"/>
            </g:FlowPanel>
        </g:north>

<!-- Aqui foi inserido um StackPanel dentro do DockPanel tipo Acordeao -->
    <g:west size="15">
        <g:StackLayoutPanel unit='EM'>
            <g:stack>
                <g:header size='3'>
                    Docentes
                </g:header>
                    <g:Button styleName="{style.botaoR}" ui:field="botao" text="Ver Docentes" />
            </g:stack>
            <g:stack>
                <g:customHeader size='3'>
                    <g:Label>Cursos</g:Label>
                </g:customHeader>

                <g:VerticalPanel>
                    <g:Label>Exemplo </g:Label>
                    <g:Label>Exemplo </g:Label>
                    <g:Label>Exemplo </g:Label>
                    <g:Label>Exemplo </g:Label>
                </g:VerticalPanel>

            </g:stack>
            <g:stack>
                <g:customHeader size='3'>
                    <g:Label>Turmas</g:Label>
                </g:customHeader>
                    <g:Label>Mais uma turma para adicionar, olarilolela</g:Label>
            </g:stack>
        </g:StackLayoutPanel>
    </g:west>

        <g:center>
            <g:FlowPanel styleName="{style.centerPanel}">
                <g:Label>Painel Central</g:Label>
            </g:FlowPanel>
        </g:center>

        <g:south size ='2'>
            <g:FlowPanel styleName="{style.southPanel}">
                <g:Label>Painel de Rodape</g:Label>
            </g:FlowPanel>
        </g:south>

    </g:DockLayoutPanel>    
</ui:UiBinder>