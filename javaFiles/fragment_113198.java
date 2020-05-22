@XmlRootElement(name = "AspectosFinancieros")
@XmlType(propOrder={"idInterventor", "numeroContrato", "ano", "valorContratoOperador", "fechaFirmaContrato",
                    "valorAdicion", "fechaProrrogaAdicion", "valorDesembolso", "fechaPagoDesembolso", 
                    "valorAnticipo", "fechaAnticipo", "valorUtilizacion", "numeroActaAprobacion",
                    "fechaUtilizacion", "valorRendimiento", "fechaRendimiento", "numeroComprobanteRendimiento",
                    "valorComision", "fechaComision", "valorGastosAdministrativos", "fechaGastosAdministrativos",
                    "nombreFiducia", "numeroContratoFiducia", "fechaContratoFiducia", "fechaProrrogaAdicionFiducia",
                    "marcaTiempo"})
public class AspectosFinancieros {