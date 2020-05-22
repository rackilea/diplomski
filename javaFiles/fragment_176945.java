package example;

import com.puppycrawl.tools.checkstyle.api.AnnotationUtility;
import com.puppycrawl.tools.checkstyle.api.Check;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class AnnotationSameLineCheck extends Check {
    @Override
    public int[] getDefaultTokens() {
        // PACKAGE_DEF and PARAMETER_DEF were left out of the list
        return new int[] { TokenTypes.ANNOTATION_DEF, //
                TokenTypes.ANNOTATION_FIELD_DEF, //
                TokenTypes.CLASS_DEF, //
                TokenTypes.CTOR_DEF, //
                TokenTypes.ENUM_DEF, //
                TokenTypes.ENUM_CONSTANT_DEF, //
                TokenTypes.INTERFACE_DEF, //
                TokenTypes.METHOD_DEF, //
                TokenTypes.VARIABLE_DEF };
    }

    @Override
    public void visitToken(DetailAST ast) {
        if (AnnotationUtility.containsAnnotation(ast)) {
            final DetailAST holder = AnnotationUtility.getAnnotationHolder(ast);
            final DetailAST annotation = getAnnotationAst(holder);
            final DetailAST prev = getPreviousSibling(annotation, holder, ast);
            final DetailAST next = getNextSibling(annotation, holder, ast);
            if (isPreviousSiblingOnSameLine(prev, annotation) || //
                    isNextSiblingOnSameLine(annotation, next)) {
                log(annotation.getLineNo(), //
                        annotation.getColumnNo(), //
                        "Annotations must exist on their own line");
            }
        }
    }

    private static boolean isPreviousSiblingOnSameLine(DetailAST prev, DetailAST annotation) {
        if (prev == null) {
            return false;
        } else if (prev.getLastChild() == null) {
            return prev.getLineNo() == annotation.getLineNo();
        }
        return prev.getLastChild().getLineNo() == annotation.getLineNo();
    }

    private static boolean isNextSiblingOnSameLine(DetailAST annotation, DetailAST next) {
        if (next == null) {
            return false;
        }
        return annotation.getLineNo() == next.getLineNo();
    }

    private static DetailAST getAnnotationAst(DetailAST aHolderAst) {
        if (aHolderAst.getType() == TokenTypes.ANNOTATIONS) {
            return aHolderAst;
        } else if (aHolderAst.getType() == TokenTypes.MODIFIERS) {
            return aHolderAst.findFirstToken(TokenTypes.ANNOTATION);
        }
        throw new AssertionError("aHolder must be one of TokenTypes.ANNOTATIONS or TokenTypes.MODIFIERS but was " + aHolderAst);
    }

    private static DetailAST getPreviousSibling(DetailAST annotation, DetailAST holder, DetailAST ast) {
        if (annotation.getPreviousSibling() != null) {
            return annotation.getPreviousSibling();
        } else if (holder.getPreviousSibling() != null) {
            return holder.getPreviousSibling();
        }
        return ast.getPreviousSibling();
    }

    private static DetailAST getNextSibling(DetailAST annotation, DetailAST holder, DetailAST ast) {
        if (annotation.getNextSibling() != null) {
            return annotation.getNextSibling();
        } else if (holder.getNextSibling() != null) {
            return holder.getNextSibling();
        }
        return ast.getNextSibling();
    }
}